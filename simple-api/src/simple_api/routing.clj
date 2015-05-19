(ns simple-api.routing
  (:require [taoclj.tao.routing :refer [deftable]]
            [simple-api.handlers :as api]
            [simple-api.items.handlers :as items]))


(deftable routes
    :public
    ["/" {:get api/hello}]
    ["/items" {:get items/get-list}]
    ["/items/:id" {:get items/detail}])
