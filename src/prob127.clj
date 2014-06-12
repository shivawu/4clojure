; 127. Love Triangle
(fn [mine]
  (let [n (count mine)
        m (loop [x (apply max mine) b 0]
            (if (zero? x) b (recur (bit-shift-right x 1) (inc b))))
        in-range (fn [[x y]]
                   (and (<= 0 x) (< x n) (<= 0 y) (< y m)))
        cell (fn [[x y]]
               (bit-test (mine x) y))
        rotate-45 (fn [[x y]]
                    (let [abs #(if (pos? %) % (- %))
                          norm #(if (zero? %) % (quot % (abs %)))]
                      (mapv norm [(+ y x) (- y x)])))
        dirs (take 8 (iterate rotate-45 [-1 0]))
        go-dir (fn [st d]
                 (take-while #(and (in-range %) (cell %)) (iterate (partial mapv + d) st)))
        filled (fn [st ed dir]
                 (when (cell ed)
                   (loop [c st len 1]
                     (cond
                       (= c ed) len
                       (cell c) (recur (mapv + c dir) (inc len))))))]
    (let [tris (for [x (range n) y (range m)
                     :when (cell [x y])
                     d1 dirs]
                 (let [d2 (-> d1 rotate-45 rotate-45)
                       d3 (rotate-45 d2)
                       p1 (go-dir [x y] d1)
                       p2 (go-dir [x y] d2)]
                   (apply + (take-while identity (map #(filled %1 %2 d3) p1 p2)))))
          mx (apply max tris)]
      (when (>= mx 3) mx))))

