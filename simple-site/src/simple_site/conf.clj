(ns simple-site.conf
  (:require [taoclj.tao :refer [gen-dispatch wrap-user]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [simple-site.auth :refer [authenticate]]
            [simple-site.routing :refer [routes]]
            [simple-site.handlers :as handlers]))




(def dispatch
    (-> (gen-dispatch routes 
                      "text/html" 
                      handlers/not-found
                      handlers/not-authorized)
        (wrap-user authenticate)
        (wrap-keyword-params)
        (wrap-params)))