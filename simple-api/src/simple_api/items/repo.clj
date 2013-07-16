(ns simple-api.items.repo)

(def db-items [{:id 1 :name "item a"}
               {:id 2 :name "item b"}
               {:id 3 :name "item c"}])


(defn get-list []
  db-items)


(defn get-item [id]
  (if id (first (filter #(= id (:id %)) 
                        db-items))))
