package icy.manipulator.model;

import icy.manipulator.Accessor;
import icy.manipulator.Manipulatable;

/**
 * {@link Manipulatable} model for {@link UserDefinedDefaultValueDefinition}.
 *
 * @version 2015-06-03T23:35:00.219
 */
public abstract class UserDefinedDefaultValue extends UserDefinedDefaultValueDefinition
        implements Manipulatable<UserDefinedDefaultValue> {

    /** The model operator for reuse. */
    public static final Manipulator<UserDefinedDefaultValue> Manipulator = new Manipulator(null);

    /**
     * HIDE CONSTRUCTOR
     */
    protected UserDefinedDefaultValue() {
    }

    /**
     * Retrieve value property.
     */
    public String value() {
        return this.value;
    }

    /**
     * Modify value property.
     */
    public UserDefinedDefaultValue value(String value) {
        this.value = value;

        return this;
    }

    /**
     * Create model builder without base model.
     */
    public static final UserDefinedDefaultValue with() {
        return new Melty(null);
    }

    /**
     * Create model builder using the specified definition as base model.
     */
    public static final UserDefinedDefaultValue with(UserDefinedDefaultValue base) {
        return new Melty(base);
    }

    /**
     * Immutable Model.
     */
    private static final class Icy extends UserDefinedDefaultValue {

        /**
         * HIDE CONSTRUCTOR
         */
        private Icy(String value) {
            this.value = value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UserDefinedDefaultValue melt() {
            return new Melty(this);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UserDefinedDefaultValue value(String value) {
            if (this.value == value) {
                return this;
            }
            return new Icy(value);
        }

    }

    /**
     * Mutable Model.
     */
    private static final class Melty extends UserDefinedDefaultValue {

        /**
         * HIDE CONSTRUCTOR
         */
        private Melty(UserDefinedDefaultValue base) {
            if (base != null) {
                this.value = base.value;
            }
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public UserDefinedDefaultValue ice() {
            return new Icy(value);
        }
    }

    /**
     * Operation Model.
     */
    public static final class Manipulator<M> extends icy.manipulator.Manipulator<M, UserDefinedDefaultValue> {

        /** The lens for value property. */
        private static final Accessor<UserDefinedDefaultValue, String> VALUE = Accessor
                .of(UserDefinedDefaultValue::value, UserDefinedDefaultValue::value);

        /**
         * Construct operator.
         */
        public Manipulator(Accessor<M, UserDefinedDefaultValue> parent) {
            super(parent);
        }

        /**
         * Property operator.
         */
        public Accessor<M, String> value() {
            return parent.then(VALUE);
        }

    }
}