import BaseInput from "/src/components/BaseInput.vue";
import { mount } from "@vue/test-utils";
import { describe, test, expect } from "vitest";

describe("BaseInput", () => {
    test("Renders properly", () => {
      const wrapper = mount(BaseInput, {props: {label: 'Hello!'}});
      expect(wrapper.text()).toContain('Hello!');
    });


});