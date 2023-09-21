package network.y9.question;

public class BuilderDefault {

    public static void main(String[] args) {

        BuildTest buildTestBuild = BuildTest.builder().type("type").build();

        BuildTest buildTest1 = new BuildTest();

        System.out.println(buildTestBuild.toString());
        System.out.println(buildTest1.toString());
    }

}
