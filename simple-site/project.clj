(defproject simple-site "0.1.0-SNAPSHOT"
  
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.taoclj/tao "0.0.2-SNAPSHOT"]
                 [org.taoclj/pure "0.0.2-SNAPSHOT"]
                 [org.taoclj/tao-mustache "0.0.2-SNAPSHOT"]]

  :plugins [[lein-ring "0.8.10"]]

  :ring {:handler simple-site.conf/dispatch
         :auto-reload? true
         :auto-refresh? true })
