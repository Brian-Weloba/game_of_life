[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]
	

# Game-of-Life
A Java implementation of Conway's Game of Life and other variations.

# Variations 
## Life-like cellular automaton
A cellular automaton (CA) is Life-like (in the sense of being similar to Conway's Game of Life) if it meets the following criteria:

- The array of cells of the automaton has two dimensions.
- Each cell of the automaton has two states (conventionally referred to as "alive" and "dead", or alternatively "on" and "off")
- The neighborhood of each cell is the Moore neighborhood; it consists of the eight adjacent cells to the one under consideration and (possibly) the cell itself.
- In each time step of the automaton, the new state of a cell can be expressed as a function of the number of adjacent cells that are in the alive state and of the - cell's own state; that is, the rule is outer totalistic (sometimes called semitotalistic).

## Notation for Rules

In the notation used by Mirek's Cellebration, a rule is written as a string x/y where each of x and y is a sequence of distinct digits from 0 to 8, in numerical order. The presence of a digit d in the x string means that a live cell with d live neighbors survives into the next generation of the pattern, and the presence of d in the y string means that a dead cell with d live neighbors becomes alive in the next generation. For instance, in this notation, Conway's Game of Life is denoted 23/3.

In the notation used by the Golly open-source cellular automaton package and in the RLE format for storing cellular automaton patterns, a rule is written in the form By/Sx where x and y are the same as in the MCell notation. Thus, in this notation, Conway's Game of Life is denoted B3/S23. The "B" in this format stands for "birth" and the "S" stands for "survival".

## Notable Rules
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
| B4678/S35678   | Anneal              | Also called the twisted majority rule. Symmetric under on-off reversal. Approximates the curve-shortening flow on the boundaries between live and dead cells.[19][20][21]   

## Contributing
Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request|



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/Brian-Weloba/game_of_life.svg?style=for-the-badge
[contributors-url]: https://github.com/Brian-Weloba/game_of_life/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/Brian-Weloba/game_of_life.svg?style=for-the-badge
[forks-url]: https://github.com/Brian-Weloba/game_of_lifee/network/members
[stars-shield]: https://img.shields.io/github/stars/Brian-Weloba/game_of_life.svg?style=for-the-badge
[stars-url]: https://github.com/Brian-Weloba/game_of_life/stargazers
[issues-shield]: https://img.shields.io/github/issues/Brian-Weloba/game_of_life.svg?style=for-the-badge
[issues-url]: https://github.com/Brian-Weloba/game_of_life/issues
[license-shield]: https://img.shields.io/github/license/Brian-Weloba/game_of_life.svg?style=for-the-badge
[license-url]: https://github.com/Brian-Weloba/game_of_life/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/brian-weloba-a02000187
[product-screenshot]: images/screenshot.png
