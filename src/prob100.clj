; 100. Least Common Multiple
(fn [& rs]
  (let [nums (map #(if (ratio? %) (numerator %) %) rs)
        dens (map #(if (ratio? %) (denominator %) 1) rs)
        gcd (fn [a b]
              (if (= b 0) a
                (recur b (mod a b))))]
    (/
      (reduce #(/ (* %1 %2) (gcd %1 %2)) nums)
      (reduce gcd dens))))

