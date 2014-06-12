; 96. Beauty is Symmetry
(fn [t]
  (let [sym? (fn _ [a b]
               (if (nil? a) (nil? b)
                 (and
                   (= (first a) (first b))
                   (_ (second a) (nth b 2))
                   (_ (second b) (nth a 2)))))]
    (or
      (nil? t)
      (sym? (second t) (nth t 2)))))

