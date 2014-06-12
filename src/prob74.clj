; 74. Filter Perfect Squares
(fn [s]
  (let [nums (map #(Integer/parseInt %) (clojure.string/split s #","))
        isPSN (fn [x]
                (some #(= x (* % %)) (range 1 (inc x))))
        psns (filter isPSN nums)]
    (clojure.string/join "," (map str psns))))

