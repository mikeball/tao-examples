(ns simple-site.routing
  (:require [taoclj.tao :refer [defroutes]]
            [simple-site.handlers :as site]
            [simple-site.items.handlers :as items]))


(defroutes routes :public 
                  ["/" {:get site/index}]
                  ["/items" {:get items/index}])