| **Expression** | **Correctness** | **Explanation** |
| --- | --- | --- |
| Doctor doctor1 = **new** Doctor(); | TRUE | Object type is equal to the reference type. |
| Doctor doctor2 = **new** MedicalStaff(); | FALSE | The "Doctor" class extends the "MedicalStaff" class. Reference  variable can't refer to the superior type objects. |
| Doctor doctor3 = **new** HeadDoctor(); | TRUE | Reference type is parent class type, thus, it is possible to refer to the subclass object. |
| Object object1 = **new** HeadDoctor(); | TRUE | In Java each class extends Object class. |
| HeadDoctor doctor5 = **new** Object(); | FALSE | The type of the reference is subclass. It is not possible to refer to the parent class using this variable type.|
| Doctor doctor6 = **new** Nurse(); | FALSE | Nurse class doesn't extend Doctor class. |
| Nurse nurse = **new** Doctor(); | FALSE | Nurse class doesn't inherit Doctor class. |
| Object object2 = **new** Nurse(); | TRUE | In Java each class extends Object class. |
| List<Doctor>; list1= **new** ArrayList<Doctor>(); | TRUE | Reference type is equals to the object type. |
| List<MedicalStaff> list2 = **new** ArrayList<Doctor>(); | FALSE | List is parameterized interface with a concrete type, thus the reference type and object type must be equal. |
| List<Doctor> list3 = **new** ArrayList<MedicalStaff>(); | FALSE | List is parameterized interface with a concrete type, thus the reference type and object type must be equal. |
| List<Object> list4 = **new** ArrayList<Doctor>(); | FALSE | List is parameterized interface with a concrete type, thus the reference type and object type must be equal. |
| List<Object> list5 = **new** ArrayList<Object>(); | TRUE | Reference type is equals to the object type. |