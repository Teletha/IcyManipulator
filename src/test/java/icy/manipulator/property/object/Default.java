package icy.manipulator.property.object;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Field;
import javax.annotation.processing.Generated;

/**
 * Generated model for {@link DefaultModel}.
 */
@Generated("Icy Manipulator")
public abstract class Default extends DefaultModel {

    /**
     * Create special property updater.
     *
     * @param name A target property name.
     * @return A special property updater.
     */
    private static final MethodHandle updater(String name)  {
        try {
            Field field = Default.class.getDeclaredField(name);
            field.setAccessible(true);
            return MethodHandles.lookup().unreflectSetter(field);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    /** The final property updater. */
    private static final MethodHandle nameUpdater = updater("name");

    /** The final property updater. */
    private static final MethodHandle standUpdater = updater("stand");

    /** The exposed property. */
    public final String name;

    /** The exposed property. */
    public final String stand;

    /**
     * HIDE CONSTRUCTOR
     */
    protected Default() {
        this.name = super.name();
        this.stand = super.stand();
    }

    /**
     * Retrieve name property.
     */
    @Override
    public final String name() {
        return this.name;
    }

    /**
     * The internal access API for name property setter.
     */
    protected abstract <T extends Default & ÅssignableÅrbitrary> T name(String value);

    /**
     * Provide classic getter API.
     */
    final String getName() {
        return this.name;
    }

    /**
     * Provide classic setter API.
     */
    final void setName(String value) {
        this.name(value);
    }

    /**
     * Retrieve stand property.
     */
    @Override
    public final String stand() {
        return this.stand;
    }

    /**
     * The internal access API for stand property setter.
     */
    protected abstract <T extends Default & ÅssignableÅrbitrary> T stand(String value);

    /**
     * Provide classic getter API.
     */
    final String getStand() {
        return this.stand;
    }

    /**
     * Provide classic setter API.
     */
    final void setStand(String value) {
        this.stand(value);
    }

    /**
     * Builder namespace for {@link Default}.
     */
    public static final class with {

        /**
         * Create uninitialized {@link Default}.
         */
        public static final <T extends Default & ÅssignableÅrbitrary> T create() {
            return (T) new Åssignable();
        }
    }

    /**
     * Mutable Model.
     */
    private static final class Åssignable extends Default implements ÅssignableÅrbitrary {

        /**
         * Initialize by first property.
         */
        private Åssignable() {
            super();
        }

        /**
         * Modify name property.
         */
        @Override
        public final <T extends Default & ÅssignableÅrbitrary> T name(String value) {
            try {
                nameUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }

        /**
         * Modify stand property.
         */
        @Override
        public final <T extends Default & ÅssignableÅrbitrary> T stand(String value) {
            try {
                standUpdater.invoke(this, value);
            } catch (Throwable e) {
                throw new Error(e);
            }
            return (T) this;
        }
    }

    /**
     * Property assignment API.
     */
    public static interface ÅssignableÅrbitrary {

        /**
         * Property assignment API.
         */
        <T extends Default & ÅssignableÅrbitrary> T name(String value);

        /**
         * Property assignment API.
         */
        <T extends Default & ÅssignableÅrbitrary> T stand(String value);
    }

    /**
     * The identifier for properties.
     */
    static final class My {
        static final String Name = "name";
        static final String Stand = "stand";
    }
}