; 150. Palindromic Numbers
(fn [low]
  (let [pow10 (fn [n]
                (nth (iterate #(* 10 %) 1) n))
        palindrome (fn [n low]
                     (let [m (quot (dec n) 2)
                           st (pow10 m)
                           lo (if (pos? low)
                                (bigint (subs (str low) 0 (inc m)))
                                st)]
                       (map
                         (if (even? n)
                           (fn [x] (bigint (apply str x (reverse (str x)))))
                           (fn [x] (bigint (apply str x (rest (reverse (str x)))))))
                         (range lo (* 10 st)))))
        ndigits (count (str low))
        bounded (drop-while #(< % low)
                  (concat
                    (palindrome ndigits low)
                    (mapcat #(palindrome % 0) (iterate inc (inc ndigits)))))]
    (if (zero? low) (cons 0 bounded)
      bounded)))

