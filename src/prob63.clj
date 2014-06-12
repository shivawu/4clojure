; 63. Group a Sequence
(fn [f coll]
  (loop [x coll map {}]
    (if (empty? x)
      map
      (let [fx (f (first x))]
        (recur (rest x) (assoc map fx (conj (get map fx []) (first x))))))))

