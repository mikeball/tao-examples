(defproject simple-api "0.1.0-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.7.0-beta3"]
                 [cheshire "5.4.0"]
                 [org.taoclj/tao "0.0.2-SNAPSHOT"]
                 [org.taoclj/pure "0.0.3-SNAPSHOT"]]

  :plugins [[lein-ring "0.9.4"]]

  :ring {:handler simple-api.conf/dispatch
         :auto-reload? true }

  )
