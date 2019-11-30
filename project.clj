(defproject night-drive "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.cli "0.4.2"]
                 [com.stripe/stripe-java "15.7.0"]
                 [environ "1.1.0"]]
  :main ^:skip-aot night-drive.core
  :target-path "target/%s"
  :plugins [[lein-environ "1.1.0" :hooks false]]
  :profiles {:uberjar {:aot :all}})
