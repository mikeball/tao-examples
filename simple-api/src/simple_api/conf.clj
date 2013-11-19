(ns simple-api.conf
  (:require [taoclj.tao :refer [gen-dispatch wrap-user]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [simple-api.auth :refer [authenticate]]
            [simple-api.routing :refer [routes]]
            [simple-api.handlers :as handlers]))




(def dispatch
    (-> (gen-dispatch routes 
                      "application/json;charset=utf-8" 
                      handlers/not-found
                      handlers/not-authorized)
        (wrap-user authenticate)
        (wrap-keyword-params)
        (wrap-params)))