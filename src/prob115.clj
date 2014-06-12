; 115. The Balance of N
(fn [n]
  (let [digits (map #(-> % str Integer/parseInt) (str n))
        hl (quot (count digits) 2)]
    (= (apply + (take hl digits)) (apply + (take-last hl digits)))))

