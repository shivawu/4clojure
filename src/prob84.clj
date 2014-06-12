; 84. Transitive Closure
(fn [s]
  (let [news (for [[a b] s [c d] s :when (= b c) :when (not (contains? s [a d]))] [a d])]
    (if (empty? news)
      s
      (recur (into s news)))))

