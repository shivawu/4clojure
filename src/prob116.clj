; 116. Prime Sandwich
(fn [p]
  (letfn [(prime? [x]
            (and (> x 1) (every? #(pos? (mod x %)) (range 2 x))))
          (last-prime [x]
            (last (filter prime? (range 2 x))))
          (next-prime [x]
            (first (filter prime? (iterate inc (inc x)))))]
    (and
      (> p 2)
      (prime? p)
      (= (+ p p) (+ (last-prime p) (next-prime p))))))

