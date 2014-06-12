; 77. Anagram Finder
(fn [s]
  (into #{}
    (for [[k v] (group-by (comp str sort seq) s) :when (> (count v) 1)]
      (set v))))

