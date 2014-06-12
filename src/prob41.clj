; 41. Drop Every Nth Item
(fn [s n]
  (keep-indexed #(if (not= (mod %1 n) (- n 1)) %2) s))

