package constants;

public enum ExtensionType {

    FIRE_BALL,
    EXTRA_BALL,
    LARGE_LUMBER,
    LITTLE_LUMBR,
    FAST_BALL,
    SLOW_BALL,
    CONFUSED_LUMBER;

    public static ExtensionType intToExtensionCode(int code) {
        switch (code) {
            case 3:
                return FIRE_BALL;
          case 2:
               return EXTRA_BALL;
//            case 2:
//                return LARGE_LUMBER;
//            case 3:
//                return LITTLE_LUMBR;
            case 4:
                return FAST_BALL;
            case 5:
                return SLOW_BALL;
            case 6:
                return CONFUSED_LUMBER;
            default:
                return null;
        }
    }

}
