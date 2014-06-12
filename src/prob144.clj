; 144. Oscilrate
(fn osc [init & fs]
  (reductions #(%2 %1) init (cycle fs)))

