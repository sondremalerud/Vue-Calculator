import { createStore } from 'vuex'

export default createStore({
    state: {
        form: {
            formName: "",
            email: "",
        }
    },
    mutations: {
        UPDATE_FORM_NAME (state, formName) {
            state.form.formName = formName
            console.log("heii")
        },
        UPDATE_EMAIL (state, email) {
            state.form.email = email
            console.log("hallo")
        }
    },
    actions: {

    },
    modules: {

    }
})