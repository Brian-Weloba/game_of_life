<img src='https://img.shields.io/github/license/Brian-Weloba/game_of_life.svg'>
<img src='https://img.shields.io/github/issues/Brian-Weloba/game_of_life.svg'>
	

# Game-of-Life
A Java implementation of Conway's Game of Life and other variations.

# Algorithms
|      Rule      |         Name        |                                                                                                                    Description                                                                                                                   |
|:--------------:|:-------------------:|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| B1357/S1357    | Replicator          | Edward Fredkin's replicating automaton: every pattern is eventually replaced by multiple copies of itself.                                                                                                                                       |
| B2/S           | Seeds               | All patterns are phoenixes, meaning that every live cell immediately dies, and many patterns lead to explosive chaotic growth. However, some engineered patterns with complex behavior are known                                                 |
| B25/S4         |                     | This rule supports a small self-replicating pattern which, when combined with a small glider pattern, causes the glider to bounce back and forth in a pseudorandom walk.                                                                         |
| B3/S012345678  | Life without Death  | Also known as Inkspot or Flakes. Cells that become alive never die. It combines chaotic growth with more structured ladder-like patterns that can be used to simulate arbitrary Boolean circuits.                                                |
| B3/S23         | Life                | Highly complex behavior.                                                                                                                                                                                                                         |
| B34/S34        | 34 Life             | Was initially thought to be a stable alternative to Life, until computer simulation found that larger patterns tend to explode. Has many small oscillators and spaceships.                                                                       |
| B35678/S5678   | Diamoeba            | Forms large diamonds with chaotically fluctuating boundaries. First studied by Dean Hickerson, who in 1993 offered a $50 prize to find a pattern that fills space with live cells; the prize was won in 1999 by David Bell.                      |
| B36/S125       | 2x2                 | If a pattern is composed of 2x2 blocks, it will continue to evolve in the same form; grouping these blocks into larger powers of two leads to the same behavior, but slower. Has complex oscillators of high periods as well as a small glider.  |
| B36/S23        | HighLife            | Similar to Life but with a small self-replicating pattern.                                                                                                                                                                                       |
| B3678/S34678   | Day & Night         | Symmetric under on-off reversal. Has engineered patterns with highly complex behavior.                                                                                                                                                           |
| B368/S245      | Morley              | Named after Stephen Morley; also called Move. Supports very high-period and slow spaceships.[2][4][18]                                                                                                                                           |
| B4678/S35678   | Anneal              | Also called the twisted majority rule. Symmetric under on-off reversal. Approximates the curve-shortening flow on the boundaries between live and dead cells.[19][20][21]                                                                        |
