(ns night-drive.checkout
  (:import com.stripe.Stripe
           com.stripe.model.Charge)
  (:require [environ.core :refer [env]]))

(defn set-api-key []
  (set! (. Stripe apiKey) (env :stripe-secret)))

(defn serialize-params
  ;; Map kwargs to explicit required Stripe parameters
  ;; <https://clojure.org/guides/destructuring#_where_to_destructure>
  [{:keys [amount currency source]}]
  { "amount" amount, "currency" currency, "source" source})

(defn push-charge-to-stripe
  ;; Use Stripe Charge API to create charge for amount, currency and source
  [charge-params]
  (set-api-key)
  (. (. Charge create (serialize-params charge-params)) toJson))
