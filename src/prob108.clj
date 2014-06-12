; 108. Lazy Searching
(fn [& s]
  (let [mins (map first s)
        m (apply min mins)]
    (if (every? (partial = m) mins)
      m
      (recur (map #(if (= (first %) m) (rest %) %) s)))))

