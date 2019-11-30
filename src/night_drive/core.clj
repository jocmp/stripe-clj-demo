(ns night-drive.core
  (:require
   [clojure.tools.cli :refer [parse-opts]]
   [night-drive.checkout :as checkout])
  (:gen-class))

(def cli-options
  ;; Read more at <https://github.com/clojure/tools.cli/>
  [["-a" "--amount AMOUNT" "Amount in subunits"
    :required true
    :parse-fn #(Integer/parseInt %)]
   ["-s" "--source SOURCE" "Stripe source"
    :required true]
   ["-c" "--currency CURRENCY" "ISO-3166 country code"
    :required true]])

(defn -main
  [& args]
  (println
   (checkout/push-charge-to-stripe (:options (parse-opts args cli-options)))))
