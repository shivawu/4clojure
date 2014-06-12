; 124. Analyze Reversi
(fn [board clr]
  (let [oppo (if (= 'w clr) 'b 'w)
        dirs [[-1 0] [1 0] [0 -1] [0 1] [-1 -1] [1 1] [-1 1] [1 -1]]
        in-range (fn [[x y]]
                   (and (<= 0 x) (< x 4) (<= 0 y) (< y 4)))
        go-dir (fn [st d a b]
                 (loop [c (map + st d) passed #{}]
                   (cond
                     (not (in-range c)) #{}
                     (= a (get-in board c)) passed
                     (= b (get-in board c)) (recur (map + c d) (conj passed c)))))]
    (into {}
      (for [x (range 4) y (range 4)
            :when (= 'e (get-in board [x y]))
            :let [cs (reduce clojure.set/union (for [d dirs] (go-dir [x y] d clr oppo)))]
            :when (not-empty cs)]
        [[x y] cs]))))

