; 111. Crossword puzzle
(fn [w b]
  (let [b (map #(apply str (flatten (partition 1 2 %))) b)
        match (fn [s t]
                (and (= (count s) (count t)) (every? true? (map #(or (= %1 %2) (= %2 \_)) s t))))
        check (fn [b]
                (some (fn [l]
                        (some (partial match w) (.split l "#"))) b))]
    (boolean
      (or
        (check b)
        (check (apply mapv str b))))))

