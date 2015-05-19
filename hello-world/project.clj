(defproject hello-world "0.1.0-SNAPSHOT"
  :description "Hello world example"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0-beta3"]
                 [org.taoclj/tao "0.0.2-SNAPSHOT"]]

  :plugins [[lein-ring "0.9.4"]]

  :ring {:handler hello-world.app/dispatch
         :auto-refresh? false } )
