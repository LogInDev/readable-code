package cleancode.minesweeper.tobe;

import cleancode.minesweeper.tobe.gamelevel.*;
import cleancode.minesweeper.tobe.io.ConsoleInputHandler;
import cleancode.minesweeper.tobe.io.ConsoleOutputHandler;
import cleancode.minesweeper.tobe.io.InputHandler;
import cleancode.minesweeper.tobe.io.OutputHandler;

public class GameApplication {
    public static void main(String[] args) {
        GameLevel gameLevel = new VeryBeginner();
        InputHandler inputHandler = new ConsoleInputHandler();
        OutputHandler outputHandler = new ConsoleOutputHandler();

        Minesweeper minesweeper = new Minesweeper(gameLevel, inputHandler, outputHandler);
        minesweeper.initialize();
        minesweeper.run();
    }

}

/**
 * DIP(Dependency Inversion Principle) : 의존성 역전
 * - 고수준 모듈과 저수준 모듈이 직접적으로 의존하는게 아니라 추상화(인터페이스 또는 추상 클리스)라는 매개를 통해 의존되어야 한다.
 *
 * IoC(Inversion of Control) : 제어의 역전
 * - 프로그램의 흐름을 개발자가 아닌 프레임워크가 담당하도록 하는 것.
 * - 제어의 순방향이란 프로그램의 흐름은 당연히 개발자가 주도한다.
 * - 제어의 역전이란 이런 제어의 흐름이 역전되었다는 걸 의미.
 * - '내'가 만든 프로그램이 미리 만들어진 공장같은 프레임워크가 있고, 그 프레임워크 안에 '내' 코드가 들어가서 일부분으로, 톱니바쿼 하나처럼 동작되는 것
 * - 프레임워크란 톱니바퀴 하나만 빠져있고 나머지는 만들어져 있는 것인데 '내'가 톱니바퀴 하나만 만들어서 프레임워크에 키우면 완성되는 것
 *  -> 이 경우 프레임워크가 메인이 된다 할 수 있다.
 *  -> 이미 만들어진 거대한 프레임워크가 메인이 되고 '내' 코드는 프레임워크의 일부가 되어서 '제어'라는게 프레임워크 쪽으로 넘어가게 된다.
 *  -> 그래서 '제어'의 주도권이 개발자가 아닌 프레임워크 쪽으로 간다.(역전)
 *
 * IoC의 DI(Dependency Injection) : 의존성 주입
 * - 필요한 의존성을 내가 직접 생성하는게 아니라 외부에서 주입 받는다.
 * - "3"
 * - 객체 A가 객체 B를 필요로 할 경우(둘이 의존성을 갖고 싶을 경우) 객체 A가 객체 B를 생성해서 사용하게 아니라 의존성을 주입받고 싶을 경우
 *  -> 생성자 또는 다른 메소드를 통해 주입받고자 할 경우 객체 A, B는 주입받는 행위를 서로 할 수 없으니 제 "3"자가 주입을 통해 의존 관계를 맺어줄 수 밖에 없다.
 *  -> Spring에서는 제 3자의 역할을 Spring Container(IoC Container)가 하게 된다. - Runtime 시점에 해당 행위가 일어나 객체 결정과 주입이 일어나게 된다.
 *
 * IoC Container가 객체(Bean)를 직접적으로 생성해주고 생명주기 관리를 해줌.
 * - IoC Container는 객체(Bean)의 생성(new)와 소멸을 해줌으로써 객체(Bean)의 생명주기를 관리해 줌.
 * - 추가로 의존성 주입(DI)까지 해줌으로써 개발자는 객체(Bean)의 생성, 소멸, 의존성 주입에 대해 신경쓰지 않고 코드만 작성하면 된다.
 */