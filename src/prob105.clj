; 105. Identify keys and values
(fn [s]
  (loop [s s cur {} k nil]
    (cond
      (empty? s) cur
      (keyword? (first s)) (recur (rest s) (assoc cur (first s) []) (first s))
      :else (recur (rest s) (assoc cur k (conj (get cur k) (first s))) k))))

