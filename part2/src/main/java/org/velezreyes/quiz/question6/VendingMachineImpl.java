package org.velezreyes.quiz.question6;

public class VendingMachineImpl implements VendingMachine {
  private int moneyInserted = 0;

  @Override
  public void insertQuarter() {
    moneyInserted += 25;
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    if (name.equals("ScottCola") && moneyInserted >= 75) {
      moneyInserted -= 75;
      return new DrinkImpl("ScottCola", true);
    } else if (name.equals("KarenTea") && moneyInserted >= 100) {
      moneyInserted -= 100;
      return new DrinkImpl("KarenTea", false);
    } else if (!name.equals("ScottCola") && !name.equals("KarenTea")) {
      throw new UnknownDrinkException();
    } else {
      throw new NotEnoughMoneyException();
    }
  }


  private class DrinkImpl implements Drink {
    private String drinkName;
    private boolean isFizzy;

    public DrinkImpl(String drinkName, boolean isFizzy) {
      this.drinkName = drinkName;
      this.isFizzy = isFizzy;
    }

    @Override
    public String getName() {
      return drinkName;
    }

    @Override
    public boolean isFizzy() {
      return isFizzy;
    }
  }

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }
}
