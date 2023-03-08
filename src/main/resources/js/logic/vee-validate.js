import { extend } from "vee-validate";
import { required } from "vee-validate/dist/rules";

extend('positive', value => {
    if (value >= 0) {
        return true;
    }

    return 'The {_field_} '
})

extend('required', {
    ...required,
    message: 'This field is required'
});