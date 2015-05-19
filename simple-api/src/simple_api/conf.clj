(ns simple-api.conf
  (:require [taoclj.tao.routing :refer [fn-dispatch]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [simple-api.auth :refer [authenticate]]
            [simple-api.routing :refer [routes]]
            [simple-api.handlers :as handlers]))



                  ;; if no handler & method match is found in the routing table
                  ;; this not-found handler is invoked and it's result is returned.
                  ;; this function must return a vector with 3 elements in the format
                  ;; [int headers body].
                  ; :not-found (fn [_] [404 {} "sorry, not found"])

                  ;; if a route match is found but the user has not been
                  ;; marked as being in any of the roles required to access
                  ;; the handler this function is invoked and the result is returned.
                  ; :not-authorized (fn [_] [403 {} "sorry, not authorized"])

(def dispatch
    (-> (fn-dispatch {:routes          routes
                      :content-type    "application/json;charset=utf-8"
                      :not-found       handlers/not-found
                      :not-authorized  handlers/not-authorized
                      :authenticate    authenticate})
        wrap-keyword-params
        wrap-params))