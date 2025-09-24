public class Mage extends Character {
    private int mana;


    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void castSpell(Character target) throws InsufficientManaException, InvalidTargetException, CharacterAlreadyDeadException {

        if ( target == null ) {
            throw new InvalidTargetException();
        } else {
            if ( !target.isAlive() ){
                String message = target.name + " ya está muerto";
                throw new CharacterAlreadyDeadException(message);
            } else {
                if ( this.mana < 9 ) {
                    String message = this.name + " no tiene maná suficiente";
                    throw new InsufficientManaException(message);
                } else {
                    if (this.mana - 10 >= 0) {
                        this.mana -= 10;
                        target.receiveDamage(20);
                        target.status = Status.POISONED;
                    }
                }
            }
        }
    }

    public void heal(Character target) throws InvalidTargetException, InsufficientManaException, CharacterAlreadyDeadException {
        if ( target == null ) {
            throw new InvalidTargetException();
        } else {
            if ( !target.isAlive() ) {
                String message = target.name + " ya está muerto";
                throw new CharacterAlreadyDeadException(message);
            } else {
                if ( this.mana < 14 ) {
                    String message = this.name + " no tiene maná suficiente";
                    throw new InsufficientManaException(message);
                } else {
                    this.mana -= 15;
                    target.health += 20;
                }
            }
        }

    }

}
