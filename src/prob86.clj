; 86. Happy numbers
(fn [x]
  (letfn [(to-digits [x]
            (map #(Integer/parseInt (str %)) (seq (str x))))
          (sqs [x]
            (reduce #(+ %1 (* %2 %2)) 0 (to-digits x)))]
    (loop [x x s #{}]
      (cond
        (= x 1) true
        (contains? s x) false
        :else (recur (sqs x) (conj s x))))))

