; 79. Triangle Minimal Path
(fn [tri]
  (loop [rows (rest tri) last (first tri)]
    (if (empty? rows)
      (apply min last)
      (let [fromlast
            (map
              (fn [ix]
                (apply min (map last (filter #(and (>= % 0) (< % (count last))) [(dec ix) ix]))))
              (range 0 (inc (count last))))]
        (recur (rest rows) (vec (map + fromlast (first rows))))))))

