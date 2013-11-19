(defproject simple-site "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.reader "0.7.3"]
                 [me.shenfeng/mustache "1.1"]
                 [org.taoclj/tao "0.0.2-SNAPSHOT"]
                 [org.taoclj/pure "0.0.2-SNAPSHOT"]
                 [org.taoclj/tao-mustache "0.0.2-SNAPSHOT"]]

  :ring {:handler simple-site.conf/dispatch
         :auto-reload? true
         :auto-refresh? true })
