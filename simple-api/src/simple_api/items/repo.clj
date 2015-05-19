(ns simple-api.items.repo)

(def db-items '({:id 1 :name "item a AA"}
                {:id 2 :name "item b"}
                {:id 3 :name "item c"}))


(defn get-items []
    db-items)


(defn lookup-item [id]
  (cond (nil? id)  nil
        (= id 4)   false  ; simulate a db connection error
        :else      (first (filter #(= id (:id %)) db-items))))
