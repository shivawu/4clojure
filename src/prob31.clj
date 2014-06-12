; 31. Pack a Sequence
(fn [s]
  (rest
    (loop [acc [] x s count 0 last nil]
      (cond
        (empty? x) (conj acc (repeat count last))
        (= last (first x)) (recur acc (rest x) (+ 1 count) last)
        :else (recur (conj acc (repeat count last)) (rest x) 1 (first x))))))

