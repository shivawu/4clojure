; 138. Squared Squared
(fn [st ed]
  (let [sqrs (take-while #(<= % ed) (iterate #(* % %) st))
        strs (apply str sqrs)
        len (first (filter #(>= % (count strs)) (map #(* % %) (range))))
        strs (apply str strs (repeat (- len (count strs)) \*))
        squares (loop [len 0 s strs sh []]
                  (if (empty? s) sh
                    (let [a (vec (subs s 0 len)) b (vec (subs s len (+ len len 1)))]
                      (recur (inc len) (subs s (+ len len 1))
                        (if (even? len)
                          (into [b] (mapv into (mapv vector (reverse a)) sh))
                          (conj (mapv conj sh a) (vec (reverse b))))))))
        rotated (let [n (count (squares 0))
                      len (dec (* 2 n))
                      fill-space (fn [s]
                                   (let [m (quot (- len (count s)) 2)]
                                     (concat (repeat m \space) s (repeat m \space))))]
                  (for [s (range len)]
                    (let [diag (for [x (range (dec n) -1 -1)
                                     :let [y (- s x)]
                                     :when (and (<= 0 y) (< y n))]
                                 ((squares x) y))]
                      (fill-space (interpose \space diag)))))]
    (map (partial apply str) rotated)))

