public class Warrior extends Character {
    int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    public void performHeavyAttack(Character target) throws InvalidTargetException, CharacterAlreadyDeadException {
        if ( target == null ) {
            throw new InvalidTargetException();
        } else {
            if (!target.isAlive() ) {
                String message = target.name + " ya está muerto";
                throw new CharacterAlreadyDeadException(message);
            } else {
                target.receiveDamage(this.strength);
            }
        }
    }

    public void enterBerserkMode() throws BerserkAlreadyActiveException {
        if (this.status.equals(Status.FURIOUS)){
            String message = this.name + " ya está en modo furioso";
            throw new BerserkAlreadyActiveException(message);
        }
        this.status = Status.FURIOUS;
    }
}
