package com.netsensia.rivalchess.utils

import junit.framework.TestCase
import org.junit.Assert
import org.junit.Test

@kotlin.ExperimentalUnsignedTypes
class FunctionsKtTest : TestCase() {

   @Test
    fun testPgnHeader() {
       Assert.assertEquals("1-0", pgnHeader(pgn, "Result"))
       Assert.assertEquals("00:01:50", pgnHeader(pgn, "GameDuration"))
   }

    private val pgn = "[Event \"?\"]\n" +
            "[Site \"?\"]\n" +
            "[Date \"2020.10.22\"]\n" +
            "[Round \"1\"]\n" +
            "[White \"Rival (build 34.0.0-1)\"]\n" +
            "[Black \"Rival (build 34.0.1-1)\"]\n" +
            "[Result \"1-0\"]\n" +
            "[BlackTimeControl \"1/move\"]\n" +
            "[ECO \"A57\"]\n" +
            "[GameDuration \"00:01:50\"]\n" +
            "[GameEndTime \"2020-10-22T12:20:56.749 UTC\"]\n" +
            "[GameStartTime \"2020-10-22T12:19:06.321 UTC\"]\n" +
            "[Opening \"Benko gambit\"]\n" +
            "[PlyCount \"139\"]\n" +
            "[WhiteTimeControl \"1/move\"]\n" +
            "\n" +
            "1. d4 {book} Nf6 {book} 2. c4 {book} c5 {book} 3. d5 {book} b5 {book}\n" +
            "4. Nf3 {book} Bb7 {book} 5. a4 {book} b4 {book} 6. Nbd2 {book} d6 {book}\n" +
            "7. e4 {book} e5 {book} 8. b3 {book} g6 {book} 9. Be2 {book} Bg7 {book}\n" +
            "10. O-O {book} O-O {book} 11. Bb2 {book} Nbd7 {book} 12. Ne1 {book} Bh6 {1.00s}\n" +
            "13. Nef3 {1.00s} Qc7 {1.00s} 14. Qc2 {1.00s} a5 {0.99s} 15. Bd3 {1.0s}\n" +
            "Rfe8 {1.0s} 16. g3 {-0.02/7 1.00s} Nb6 {1.00s} 17. Rfe1 {1.00s} Qd7 {1.0s}\n" +
            "18. Bf1 {1.00s} Re7 {0.99s} 19. Bg2 {1.0s} Rae8 {0.98s} 20. h3 {-0.14/8 1.00s}\n" +
            "Ba6 {1.00s} 21. Nf1 {1.00s} Bb7 {1.00s} 22. Ne3 {0.99s} Qc7 {1.00s}\n" +
            "23. Nh2 {1.00s} Bg5 {1.00s} 24. Bc1 {1.00s} Bh6 {1.00s} 25. Nf5 {1.00s}\n" +
            "gxf5 {1.00s} 26. Bxh6 {1.00s} Nxe4 {1.00s} 27. Ng4 {1.00s} fxg4 {1.00s}\n" +
            "28. Bxe4 {1.00s} gxh3 {1.00s} 29. Bxh7+ {1.00s} Kh8 30. Bg5 {0.99s} Kg7 {1.00s}\n" +
            "31. Bxe7 {1.00s} Qxe7 {1.00s} 32. Re4 {1.00s} Qf6 {1.00s} 33. Rh4 {1.00s}\n" +
            "Bc8 {1.00s} 34. Re1 {1.00s} Kf8 {1.00s} 35. Qd2 {1.00s} Ke7 {1.00s}\n" +
            "36. Kf1 {1.00s} Bd7 {1.00s} 37. Qe2 {1.00s} Qg5 {1.00s} 38. Rh5 {1.00s}\n" +
            "Qg4 {1.00s} 39. Qxg4 {1.00s} Bxg4 {1.00s} 40. Rh4 {1.00s} Rh8 {0.95s}\n" +
            "41. Rxg4 {+1.28/10 1.0s} Rxh7 {1.00s} 42. Rh4 {1.00s} Rxh4 {1.00s}\n" +
            "43. gxh4 {0.95s} f5 {0.95s} 44. Re3 {1.00s} h2 {1.00s} 45. Rh3 {1.00s}\n" +
            "Kf7 {1.00s} 46. h5 {1.00s} Nc8 {0.95s} 47. h6 {1.0s} Kg8 {1.00s} 48. h7+ {1.00s}\n" +
            "Kh8 {1.00s} 49. Rxh2 {1.00s} f4 {1.00s} 50. Rh6 {1.00s} f3 {1.00s}\n" +
            "51. Ke1 {1.00s} e4 {1.00s} 52. Kd2 {0.95s} Ne7 {0.95s} 53. Rf6 {0.95s}\n" +
            "Kg7 {1.00s} 54. Ke3 {1.00s} Kxh7 {0.95s} 55. Rf7+ {1.00s} Kg6 {0.95s}\n" +
            "56. Rxe7 {1.00s} Kf6 {1.00s} 57. Ra7 {1.00s} Kf5 {1.00s} 58. Rf7+ {1.00s}\n" +
            "Kg4 {0.95s} 59. Rd7 {0.95s} Kh4 {1.00s} 60. Rg7 {1.00s} Kh5 {0.95s}\n" +
            "61. Kxe4 {1.00s} Kh6 {0.95s} 62. Rg1 {1.0s} Kh7 {0.95s} 63. Kf5 {1.00s}\n" +
            "Kh6 {1.00s} 64. Ke4 {0.94s} Kh7 {0.96s} 65. Kf5 {0.99s} Kh8 {1.00s}\n" +
            "66. Rg6 {1.00s} Kh7 67. Kg5 Kh8 68. Kf6 Kh7 69. Kf7 Kh8 70. Rh6# {White mates}\n" +
            "1-0\n" +
            "\n"

}