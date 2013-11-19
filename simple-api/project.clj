(defproject simple-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [cheshire "5.2.0"]
                 [org.taoclj/tao "0.0.2-SNAPSHOT"]
                 [org.taoclj/pure "0.0.2-SNAPSHOT"]]

  :ring {:handler simple-api.conf/dispatch
         :auto-refresh? false })
