; 55. Count Occurences
(fn [s]
  (into {} (for [[k v] (group-by identity s)] [k (count v)])))

