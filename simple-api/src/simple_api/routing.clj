(ns simple-api.routing
  (:require [taoclj.tao :refer [defroutes]]
            [simple-api.handlers :as api]
            [simple-api.items.handlers :as items]))


(defroutes routes :public 
                  ["/" {:get api/hello}]
                  ["/items" {:get items/list}]
                  ["/items/:id" {:get items/detail}])