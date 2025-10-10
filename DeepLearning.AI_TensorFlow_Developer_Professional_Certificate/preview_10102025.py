import os, random
import tensorflow as tf
import numpy as np

import matplotlib.pyplot as plt
import matplotlib.image as mpimg


class myCallback(tf.keras.callbacks.Callback):
    """
    https://www.tensorflow.org/api_docs/python/tf/keras/callbacks/Callback
    """
    def on_epoch_end(self, epoch, logs=None):
        if(logs.get('accuracy') >= 0.6): # Experiment with changing this value
            print("\nReached 60% accuracy so cancelling training!")
            self.model.stop_training = True


class Preview_10102025:
    """
    the rule of thumb that the first layer in your network should be the same shape as your data
    Another rule of thumb -- the number of neurons in the last layer should match the number of classes you are classifying for

    The loss function measures the guessed answers against the known correct answers and measures how well or how badly it did
    The optimizer function to make another guess

    Sequential: That defines a sequence of layers in the neural network.
    Flatten: takes that square pixcel matrix and turns it into a 1-dimensional array.
    Dense: Adds a layer of neurons
    Dropout layer to avoid overfitting
    Each layer of neurons needs an activation function to tell them what to do. There are a lot of options, but just use these for now:
        ReLU effectively means: return x if x > 0 else 0
            In other words, it only passes values greater than 0 to the next layer in the network.
        Softmax takes a list of values and scales these so the sum of all elements will be equal to 1.
            When applied to model outputs, you can think of the scaled values as the probability for that class.
                For example, in your classification model which has 10 units in the output dense layer, having the highest value at index = 4
                means that the model is most confident that the input clothing image is a coat
                If it is at index = 5, then it is a sandal, and so forth. See try_softmax() method which demonstrates these concepts
        with a two-class classification problem (i.e. a binary classification problem)
            you will train the model with the binary_crossentropy loss and end your network with a sigmoid activation.
            a sigmoid activation makes the output value of your network to be a number between 0 and 1

    The main concept of convolutions is that they narrow down the content of the image to focus on specific parts
        tf.keras.layers.Conv2D(64, (3,3), activation='relu')
    MaxPool2D layer is designed to compress the image, while maintaining the content of the features that were highlighted by the convolution
        tf.keras.layers.MaxPooling2D(2, 2)
            the idea is that it creates a 2x2 array of pixels, and picks the biggest one

    overfitting occurs when the network learns the data from the training set really well
        but it's too specialised to only that data, and as a result is less effective at interpreting other unseen data
        One simple method to avoid overfitting is to augment the images

    use the image_from_dataset_directory utility to read pictures in the source folders, convert them to tensors, and combine them with their labels to form a tf.data.Dataset
        This uses the tf.data API which is optimized for parallel processing such as feeding data to GPUs and TPUs
        It makes the training much faster than when using regular Numpy arrays

    a few more methods to configure the dataset:
        cache() stores elements in memory as you use them so it will be faster to retrieve if you need them again
        shuffle(), as the name suggests, shuffles the dataset randomly
            A buffer_size of 1000 means it will first select a sample from the first 1,000 elements
            then keep filling this buffer until all elements have been selected.
        prefetch() gets elements while the model is training so it's faster to feed in new data when the current training step is finished
            A buffer_size set to tf.data.AUTOTUNE dynamically sets the number of elements to prefetch during runtime.

    transfer learning
        use a pre-trained model to achieve good results even with a small training dataset
        leveraging the trained layers of an existing model and adding own layers to fit the application
        For example
            just get the convolution layers of one model
            attach some dense layers onto it
            train just the dense network
            evaluate the results
    """

    def c1w1(self):
        # Declare model inputs and outputs for training
        xs = np.array([-1.0, 0.0, 1.0, 2.0, 3.0, 4.0], dtype=float)
        ys = np.array([-3.0, -1.0, 1.0, 3.0, 5.0, 7.0], dtype=float)

        # Build a simple Sequential model
        model = self.c1w1_define_and_compile_model()
        # Train the model
        model.fit(xs, ys, epochs=500)

        # Make a prediction
        print(f"model predicted: {model.predict(np.array([10.0]), verbose=0).item():.5f}")

    def c1w1_Week1AssignmentHousingPrices(self):
        features, targets = self.c1w1_Week1AssignmentHousingPrices_create_training_data()

        print(f"Features have shape: {features.shape}")
        print(f"Targets have shape: {targets.shape}")

        untrained_model = self.c1w1_define_and_compile_model()
        untrained_model.summary()

        # Get your trained model
        trained_model = self.c1w1_Week1AssignmentHousingPrices_train_model()

        new_n_bedrooms = np.array([7.0])
        predicted_price = trained_model.predict(new_n_bedrooms, verbose=False).item()
        print(
            f"Your model predicted a price of {predicted_price:.2f} hundreds of thousands of dollars for a {int(new_n_bedrooms.item())} bedrooms house")

    def c1w2(self):
        # Load the Fashion MNIST dataset
        fmnist = tf.keras.datasets.fashion_mnist
        # Load the training and test split of the Fashion MNIST dataset
        (training_images, training_labels), (test_images, test_labels) = fmnist.load_data()

        # Normalize the pixel values of the train and test images
        training_images = training_images / 255.0
        test_images = test_images / 255.0
        # self.showdemo(training_labels, training_images, index=10)

        model = self.c1w3_define_and_compile_model()
        # model = self.c1w2_define_and_compile_model(
        #     # ex2=True,
        #     ex3=True,
        #     # ex5=True,
        # )
        model.fit(
            training_images,
            training_labels,
            epochs=5,
            # callbacks=[callbacks],  # ex8
        )


        # Evaluate the model on unseen data
        model.evaluate(test_images, test_labels)

        classifications = model.predict(test_images)
        # print(classifications[0])
        print(f"\nTrue class for 10th image on test set: {test_labels[10]}\nProbability of each class:\n{classifications[10]}")

    def c1w4__image_dataset_from_directory_of_tf(
            self,
            TRAIN_DIR,
            VAL_DIR=None,
            image_size=(300, 300),
            batch_size=32,
            label_mode='binary'
    ):

        # Instantiate the dataset
        train_dataset = tf.keras.utils.image_dataset_from_directory(
            TRAIN_DIR,
            image_size=image_size,
            batch_size=batch_size,
            label_mode=label_mode,
        )
        # self.readdataset(train_dataset)

        train_dataset_scaled = train_dataset.map(lambda image, label: (rescale_layer(image), label))
        # self.readdataset(train_dataset_scaled)
        # train_dataset_scaled = self.make_faster(train_dataset_scaled)

        if VAL_DIR is not None:
            validation_dataset = tf.keras.utils.image_dataset_from_directory(
                VAL_DIR,
                image_size=image_size,
                batch_size=batch_size,
                label_mode=label_mode,
            )
            validation_dataset_scaled = validation_dataset.map(lambda image, label: (rescale_layer(image), label))
            # validation_dataset_scaled = self.make_faster(validation_dataset_scaled, val=True)
        else:
            validation_dataset_scaled = None

        model = self.c1w4_define_and_compile_model()

        EPOCHS = 15
        history = model.fit(
            train_dataset_scaled,
            epochs=EPOCHS,
            verbose=2
        ) if validation_dataset_scaled is None else model.fit(
            train_dataset_scaled,
            epochs=EPOCHS,
            validation_data = validation_dataset_scaled,
            verbose=2
        )
        self.show_training(history)

    def c2w2__image_dataset_from_directory_of_tf(
            self,
            train_dir,
            validation_dir,
            image_size=(150, 150),
            batch_size=20,
            label_mode='binary',
            returnmodel=True
    ):
        # Instantiate the training dataset
        train_dataset = tf.keras.utils.image_dataset_from_directory(
            train_dir,
            image_size=image_size,
            batch_size=batch_size,
            label_mode=label_mode
        )
        # Instantiate the validation dataset
        validation_dataset = tf.keras.utils.image_dataset_from_directory(
            validation_dir,
            image_size=image_size,
            batch_size=batch_size,
            label_mode=label_mode
        )

        train_dataset_final = self.make_faster(train_dataset)
        validation_dataset_final = self.make_faster(validation_dataset, val=True)
        if not returnmodel:
            return None, list(train_dataset.take(1))[0][0], train_dataset_final, validation_dataset_final

        EPOCHS = 20
        # Create a new model
        model = self.c2w2_create_model()
        # Setup the training parameters
        model.compile(loss='binary_crossentropy',
                      optimizer=tf.keras.optimizers.RMSprop(learning_rate=1e-4),
                      metrics=['accuracy'])
        # Train the model
        history = model.fit(
            train_dataset_final,
            epochs=EPOCHS,
            validation_data=validation_dataset_final,
            verbose=2
        )
        self.show_training(history)
        return model, list(train_dataset.take(1))[0][0], train_dataset_final, validation_dataset_final

    def c2w2__data_augmentation(self, train_dir, validation_dir):
        model_without_aug, sample_batch, train_dataset_final, validation_dataset_final = \
            self.c2w2__image_dataset_from_directory_of_tf(train_dir, validation_dir)

        data_augmentation = self.model_augmentation()
        self.demo_augmentation(sample_batch[0], data_augmentation, NUM_AUG=4)
        self.demo_augmentation(sample_batch[1], data_augmentation, NUM_AUG=4)
        self.demo_augmentation(sample_batch[2], data_augmentation, NUM_AUG=4)
        self.demo_augmentation(sample_batch[3], data_augmentation, NUM_AUG=4)

        model_with_aug = self.c2w2_define_and_compile_model(
            data_augmentation,
            model_without_aug
        )

        EPOCHS = 80
        # Train the new model
        history = model_with_aug.fit(
            train_dataset_final,
            epochs=EPOCHS,
            validation_data=validation_dataset_final,
            verbose=2
        )
        self.show_training(history)

    # def c2w2__data_augmentation_(self, train_dir, validation_dir):
    #     _, sample_batch, train_dataset_final, validation_dataset_final = \
    #         self.c2w2__image_dataset_from_directory_of_tf(train_dir, validation_dir, returnmodel=False)
    #     model_without_aug = self.c2w2_create_model__the_same_as_c1w4()
    #
    #     data_augmentation = self.model_augmentation(inputshape=(300,300,3))
    #     self.demo_augmentation(sample_batch[0], data_augmentation, NUM_AUG=4)
    #     self.demo_augmentation(sample_batch[1], data_augmentation, NUM_AUG=4)
    #     self.demo_augmentation(sample_batch[2], data_augmentation, NUM_AUG=4)
    #     self.demo_augmentation(sample_batch[3], data_augmentation, NUM_AUG=4)
    #
    #     model_with_aug = self.c2w2_define_and_compile_model(
    #         data_augmentation,
    #         model_without_aug
    #     )
    #
    #     EPOCHS = 20
    #     # Train the new model
    #     history = model_with_aug.fit(
    #         train_dataset_final,
    #         epochs=EPOCHS,
    #         validation_data=validation_dataset_final,
    #         verbose=2
    #     )
    #     self.show_training(history)

    def c2w3_transfer_learning(self, train_dir, validation_dir):
        def preprocess(image, label):
            image = tf.keras.applications.inception_v3.preprocess_input(image)
            return image, label

        pre_trained_model = self.c2w3_load_pretrained_model()
        pre_trained_model.summary()

        model = self.c2w3_add_more2pretrained_model(pre_trained_model)
        model.summary()  # Print the model summary. See your dense network connected at the end.

        _, _, train_dataset, validation_dataset = self.c2w2__image_dataset_from_directory_of_tf(train_dir, validation_dir, returnmodel=False)
        # Apply the preprocessing to the datasets
        train_dataset_scaled, validation_dataset_scaled = train_dataset.map(preprocess), validation_dataset.map(preprocess)
        train_dataset_final, validation_dataset_final = self.make_faster(train_dataset_scaled), self.make_faster(validation_dataset_scaled, val=True)

        model_with_aug = self.model_augmentation_(model)

        EPOCHS = 20
        history = model_with_aug.fit(
            train_dataset_final,
            validation_data=validation_dataset_final,
            epochs=EPOCHS,
            verbose=2
        )
        self.show_training(history)

    def c2w4__multi_class_classifier(self, train_dir, validation_dir):
        _, _, train_dataset_final, validation_dataset_final = self.c2w2__image_dataset_from_directory_of_tf(
            train_dir,
            validation_dir,
            image_size=(150, 150),
            batch_size=32,
            label_mode='categorical',
            returnmodel=True
        )
        model = self.c2w4_define_and_compile_model()
        model_with_aug = self.model_augmentation_(
            model,
            loss='categorical_crossentropy',
            optimizer='rmsprop',
            metrics=['accuracy']
        )

        EPOCHS = 25
        history = model_with_aug.fit(
            train_dataset_final,
            validation_data=validation_dataset_final,
            epochs=EPOCHS,
            verbose=2
        )
        self.show_training(history)

    def c1w1_Week1AssignmentHousingPrices_create_training_data(self):
        """Creates the data that will be used for training the model.

        Returns:
            (numpy.ndarray, numpy.ndarray): Arrays that contain info about the number of bedrooms and price in hundreds of thousands for 6 houses.
        """
        # Define feature and target tensors with the values for houses with 1 up to 6 bedrooms.
        # For this exercise, please arrange the values in ascending order (i.e. 1, 2, 3, and so on).
        # Hint: Remember to explictly set the dtype as float when defining the numpy arrays
        n_bedrooms = []
        price_in_hundreds_of_thousands = []
        for bedr in range(6):
            bedr_ = float(bedr + 1)
            n_bedrooms.append(bedr_)
            price_in_hundreds_of_thousands.append(0.50 + 0.50 * bedr_)
        n_bedrooms = np.array(n_bedrooms)
        price_in_hundreds_of_thousands = np.array(price_in_hundreds_of_thousands)

        return n_bedrooms, price_in_hundreds_of_thousands

    def c1w1_Week1AssignmentHousingPrices_train_model(self):
        """Returns the trained model.

        Returns:
            tf.keras.Model: The trained model that will predict house prices.
        """
        # Define feature and target tensors with the values for houses with 1 up to 6 bedrooms
        # Hint: Remember you already coded a function that does this!
        n_bedrooms, price_in_hundreds_of_thousands = self.c1w1_Week1AssignmentHousingPrices_create_training_data()

        # Define a compiled (but untrained) model
        # Hint: Remember you already coded a function that does this!
        model = self.c1w1_define_and_compile_model()

        # Train your model for 500 epochs by feeding the training data
        model.fit(n_bedrooms, price_in_hundreds_of_thousands, epochs=500)
        return model

    def c1w1_define_and_compile_model(self):
        """Returns the compiled (but untrained) model.

        Returns:
            tf.keras.Model: The model that will be trained to predict house prices.
        """
        # Define your model
        model = tf.keras.Sequential([
            # Define the Input with the appropriate shape
            tf.keras.Input(shape=(1,)),
            # Define the Dense layer
            tf.keras.layers.Dense(units=1),
        ])

        # Compile your model
        model.compile(optimizer='sgd', loss='mean_squared_error')
        return model

    def c1w2_define_and_compile_model(self, ex2=False, ex3=False, ex5=False):
        if ex2:
            un = 512
        elif ex3:
            un = 64
        elif ex5:
            un = 256
        else:
            un = 128
        model = tf.keras.models.Sequential([
            tf.keras.Input(shape=(28, 28)),
            tf.keras.layers.Flatten(),
            tf.keras.layers.Dense(un, activation=tf.nn.relu),  # , activation='relu'),,
            tf.keras.layers.Dense(10, activation=tf.nn.softmax)  # , activation='softmax')
        ])
        model.summary()  # review the network architecture and the output shapes
        model.compile(optimizer=tf.optimizers.Adam(),
                      loss='sparse_categorical_crossentropy',
                      metrics=['accuracy'])
        return model

    def c1w3_define_and_compile_model(self):
        un = 128
        model = tf.keras.models.Sequential([
            tf.keras.Input(shape=(28, 28, 1)),
            tf.keras.layers.Conv2D(64, (3,3), activation='relu'),
            # tf.keras.layers.Conv2D(64, (3,3), activation='relu', input_shape=(28, 28, 1)),
            tf.keras.layers.MaxPooling2D(2, 2),
            tf.keras.layers.Flatten(),
            tf.keras.layers.Dense(un, activation=tf.nn.relu),  # , activation='relu'),,
            tf.keras.layers.Dense(10, activation=tf.nn.softmax)  # , activation='softmax')
        ])
        model.summary()  # review the network architecture and the output shapes
        model.compile(optimizer=tf.optimizers.Adam(),
                      loss='sparse_categorical_crossentropy',
                      metrics=['accuracy'])
        return model

    def c1w4_define_and_compile_model(self):
        model = tf.keras.models.Sequential([
            # Note the input shape is the desired size of the image 300x300 with 3 bytes color
            # This is the first convolution
            tf.keras.Input(shape=(300, 300, 3)),
            tf.keras.layers.Conv2D(16, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # The second convolution
            tf.keras.layers.Conv2D(32, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # The third convolution
            tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # The fourth convolution
            tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # The fifth convolution
            tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # Flatten the results to feed into a DNN
            tf.keras.layers.Flatten(),
            # 512 neuron hidden layer
            tf.keras.layers.Dense(512, activation='relu'),
            # Only 1 output neuron. It will contain a value from 0 to 1 where 0 is for 'horses' and 1 for 'humans'
            tf.keras.layers.Dense(1, activation='sigmoid')
        ])
        model.summary()  # review the network architecture and the output shapes
        model.compile(
            loss='binary_crossentropy',  # if it's a binary classification problem, train the model with the binary_crossentropy loss and the final activation is a sigmoid
            optimizer=tf.keras.optimizers.RMSprop(learning_rate=0.001),
            metrics=['accuracy']
        )
        return model

    def c2w2_define_and_compile_model(self, data_augmentation, model_without_aug):
        model = tf.keras.models.Sequential([
            data_augmentation,
            model_without_aug
        ])
        # model.summary()  # review the network architecture and the output shapes
        # Compile the model
        model.compile(
            loss='binary_crossentropy',  # if it's a binary classification problem, train the model with the binary_crossentropy loss and the final activation is a sigmoid
            optimizer=tf.keras.optimizers.RMSprop(learning_rate=1e-4),
            metrics=['accuracy'])
        return model

    @staticmethod
    def c2w2_create_model():
        '''Creates a CNN with 4 convolutional layers'''
        model = tf.keras.models.Sequential([
            tf.keras.Input(shape=(150, 150, 3)),
            tf.keras.layers.Rescaling(1. / 255),
            tf.keras.layers.Conv2D(32, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            tf.keras.layers.Conv2D(128, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            tf.keras.layers.Conv2D(128, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            tf.keras.layers.Flatten(),
            tf.keras.layers.Dense(512, activation='relu'),
            tf.keras.layers.Dense(1, activation='sigmoid')
        ])

        return model

    # @staticmethod
    # def c2w2_create_model__the_same_as_c1w4():
    #     model = tf.keras.models.Sequential([
    #         tf.keras.Input(shape=(300, 300, 3)),
    #         # This will rescale the image to [0,1]
    #         tf.keras.layers.Rescaling(1. / 255),
    #         # This is the first convolution
    #         tf.keras.layers.Conv2D(16, (3, 3), activation='relu'),
    #         tf.keras.layers.MaxPooling2D(2, 2),
    #         # The second convolution
    #         tf.keras.layers.Conv2D(32, (3, 3), activation='relu'),
    #         tf.keras.layers.MaxPooling2D(2, 2),
    #         # The third convolution
    #         tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
    #         tf.keras.layers.MaxPooling2D(2, 2),
    #         # The fourth convolution
    #         tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
    #         tf.keras.layers.MaxPooling2D(2, 2),
    #         # The fifth convolution
    #         tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
    #         tf.keras.layers.MaxPooling2D(2, 2),
    #         # Flatten the results to feed into a DNN
    #         tf.keras.layers.Flatten(),
    #         # 512 neuron hidden layer
    #         tf.keras.layers.Dense(512, activation='relu'),
    #         # Only 1 output neuron. It will contain a value from 0-1 where 0 for one class ('horses') and 1 for the other ('humans')
    #         tf.keras.layers.Dense(1, activation='sigmoid')
    #     ])
    #     model.summary()
    #     return model

    @staticmethod
    def c2w3_load_pretrained_model(
            model=None,
            local_weights_file=None,
    ):
        """
        with `tf.keras.applications.inception_v3.InceptionV3()`, The weights are saved in the following URL:
            https://storage.googleapis.com/mledu-datasets/inception_v3_weights_tf_dim_ordering_tf_kernels_notop.h5
        """
        if model is None:
            # Initialize the base model.
            # Set the input shape and remove the dense layers.
            model = tf.keras.applications.inception_v3.InceptionV3(
                input_shape=(150, 150, 3),
                include_top=False,
                weights=None
            )

        if local_weights_file is not None:  # Load the pre-trained weights you downloaded.
            model.load_weights(local_weights_file)  # help model have a initial knowledge

        # Freeze the weights of the layers, so original knowledge will be kept, only new parts will be trained
        for layer in model.layers:
            layer.trainable = False
        return model

    @staticmethod
    def c2w3_add_more2pretrained_model(model=None):
        # Choose `mixed7` as the last layer of your base model
        last_layer = model.get_layer('mixed7')
        print('last layer output shape: ', last_layer.output.shape)

        # Flatten the output layer to 1 dimension
        x = tf.keras.layers.Flatten()(last_layer.output)  # Build upon the output of `last_layer`
        # layers after `mixed7` in `pre_trained_model` are not removed, but will not connect to new model

        # Add a fully connected layer with 1,024 hidden units and ReLU activation
        x = tf.keras.layers.Dense(1024, activation='relu')(x)
        # Add a dropout rate of 0.2
        x = tf.keras.layers.Dropout(0.2)(x)
        # Add a final sigmoid layer for classification
        x = tf.keras.layers.Dense(1, activation='sigmoid')(x)

        # Append the dense network to the base model
        return tf.keras.Model(model.input, x)

    @staticmethod
    def c2w4_define_and_compile_model():
        model = tf.keras.models.Sequential([
            tf.keras.Input(shape=(150, 150, 3)),
            # Rescale the image. Note the input shape is the desired size of the image: 150x150 with 3 bytes for color
            tf.keras.layers.Rescaling(1. / 255),
            # This is the first convolution
            tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # The second convolution
            tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # The third convolution
            tf.keras.layers.Conv2D(128, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # The fourth convolution
            tf.keras.layers.Conv2D(128, (3, 3), activation='relu'),
            tf.keras.layers.MaxPooling2D(2, 2),
            # Flatten the results to feed into a DNN
            tf.keras.layers.Flatten(),
            tf.keras.layers.Dropout(0.5),
            # 512 neuron hidden layer
            tf.keras.layers.Dense(512, activation='relu'),
            tf.keras.layers.Dense(3, activation='softmax')
        ])

        # Print the model summary
        model.summary()
        return model

    def try_softmax(self, inputs=np.array([[1.0, 3.0, 4.0, 2.0]])):
        # Declare sample inputs and convert to a tensor
        inputs = tf.convert_to_tensor(inputs)
        print(f'input to softmax function: {inputs.numpy()}')

        # Feed the inputs to a softmax activation function
        outputs = tf.keras.activations.softmax(inputs)
        print(f'output of softmax function: {outputs.numpy()}')

        # Get the sum of all values after the softmax
        sum = tf.reduce_sum(outputs)
        print(f'sum of outputs: {sum}')

        # Get the index with highest value
        prediction = np.argmax(outputs)
        print(f'class with highest probability: {prediction}')

    def showdemo(self, training_labels, training_images, index=0):
        # Set number of characters per row when printing
        np.set_printoptions(linewidth=320)

        # Print the label and image
        print(f'LABEL: {training_labels[index]}')
        print(f'\nIMAGE PIXEL ARRAY:\n\n{training_images[index]}\n\n')

        # Visualize the image using the default colormap (viridis)
        plt.imshow(training_images[index])
        plt.colorbar()
        plt.show()

    def reference_img_from__image_dataset_from_directory_of_tf(self, file, model):
        image = tf.keras.utils.load_img(file, target_size=(300, 300))
        image = tf.keras.utils.img_to_array(image)
        image = rescale_layer(image)
        image = np.expand_dims(image, axis=0)

        prediction = model.predict(image, verbose=0)[0][0]

    def read__image_dataset_from_directory_of_tf(self, train_dataset):
        print(f'train_dataset inherits from tf.data.Dataset: {issubclass(type(train_dataset), tf.data.Dataset)}')

        # Get one batch from the dataset
        sample_batch = list(train_dataset.take(1))[0]
        # Extract image and label
        image_batch = sample_batch[0]
        label_batch = sample_batch[1]

        # Check that the output is a pair
        print(f'sample batch data type: {type(sample_batch)}')
        print(f'number of elements: {len(sample_batch)}')

        # Check the shapes
        print(f'image batch shape: {image_batch.shape}')
        print(f'label batch shape: {label_batch.shape}')
        print(image_batch[0].numpy())
        # Check the range of values
        print(f'max value: {np.max(image_batch[0].numpy())}')
        print(f'min value: {np.min(image_batch[0].numpy())}')

        # # preprocess the images by normalizing the pixel values to be in the `[0, 1]` range
        # image_scaled = rescale_layer(image_batch[0]).numpy()
        # print(image_scaled)

    @staticmethod
    def make_faster(train_dataset_scaled, val=False):
        return train_dataset_scaled\
            .cache()\
            .shuffle(SHUFFLE_BUFFER_SIZE)\
            .prefetch(PREFETCH_BUFFER_SIZE) if not val else train_dataset_scaled\
            .cache()\
            .prefetch(PREFETCH_BUFFER_SIZE)

    @staticmethod
    def visualizing_intermediate_representations(model, img_path):
        successive_outputs = [layer.output for layer in model.layers[1:]]
        visualization_model = tf.keras.models.Model(inputs=model.inputs, outputs=successive_outputs)

        img = tf.keras.utils.load_img(img_path, target_size=(300, 300))  # this is a PIL image
        x = tf.keras.utils.img_to_array(img)  # Numpy array with shape (300, 300, 3)
        x = x.reshape((1,) + x.shape)  # Numpy array with shape (1, 300, 300, 3)

        # Scale by 1/255
        x = rescale_layer(x)

        # Run the image through the network, thus obtaining all
        # intermediate representations for this image.
        successive_feature_maps = visualization_model.predict(x, verbose=False)

        # These are the names of the layers, so you can have them as part of the plot
        layer_names = [layer.name for layer in model.layers[1:]]

        # Display the representations
        for layer_name, feature_map in zip(layer_names, successive_feature_maps):
            if len(feature_map.shape) == 4:

                # Just do this for the conv / maxpool layers, not the fully-connected layers
                n_features = feature_map.shape[-1]  # number of features in feature map

                # The feature map has shape (1, size, size, n_features)
                size = feature_map.shape[1]

                # Tile the images in this matrix
                display_grid = np.zeros((size, size * n_features))
                for i in range(n_features):
                    x = feature_map[0, :, :, i]
                    x -= x.mean()
                    x /= x.std()
                    x *= 64
                    x += 128
                    x = np.clip(x, 0, 255).astype('uint8')

                    # Tile each filter into this big horizontal grid
                    display_grid[:, i * size: (i + 1) * size] = x

                # Display the grid
                scale = 20. / n_features
                plt.figure(figsize=(scale * n_features, scale))
                plt.title(layer_name)
                plt.grid(False)
                plt.imshow(display_grid, aspect='auto', cmap='viridis')

    @staticmethod
    def visualizing_the_convolutions_and_pooling(
            model,
            data,
            FIRST_IMAGE=0,
            SECOND_IMAGE=23,
            THIRD_IMAGE=28,
            CONVOLUTION_NUMBER=1,
    ):
        """Visualizing the Convolutions and Pooling"""
        layers_to_visualize = [tf.keras.layers.Conv2D, tf.keras.layers.MaxPooling2D]
        layer_outputs = [layer.output for layer in model.layers if type(layer) in layers_to_visualize]
        activation_model = tf.keras.models.Model(inputs=model.inputs, outputs=layer_outputs)

        f, axarr = plt.subplots(3, len(layer_outputs))

        for x in range(len(layer_outputs)):
            f1 = activation_model.predict(data[FIRST_IMAGE].reshape(1, 28, 28, 1), verbose=False)[x]
            axarr[0, x].imshow(f1[0, :, :, CONVOLUTION_NUMBER], cmap='inferno')
            axarr[0, x].grid(False)

            f2 = activation_model.predict(data[SECOND_IMAGE].reshape(1, 28, 28, 1), verbose=False)[x]
            axarr[1, x].imshow(f2[0, :, :, CONVOLUTION_NUMBER], cmap='inferno')
            axarr[1, x].grid(False)

            f3 = activation_model.predict(data[THIRD_IMAGE].reshape(1, 28, 28, 1), verbose=False)[x]
            axarr[2, x].imshow(f3[0, :, :, CONVOLUTION_NUMBER], cmap='inferno')
            axarr[2, x].grid(False)

    def manual_convolution(self, ascent_image, weight=1):
        filter = [[0, 1, 0], [1, -4, 1], [0, 1, 0]]
        # filter = [ [-1, -2, -1], [0, 0, 0], [1, 2, 1]]
        # filter = [ [-1, 0, 1], [-2, 0, 2], [-1, 0, 1]]

        image_transformed = np.copy(ascent_image)
        size_x = image_transformed.shape[0]
        size_y = image_transformed.shape[1]

        for x in range(1, size_x - 1):
            for y in range(1, size_y - 1):
                convolution = 0.0
                convolution = convolution + (ascent_image[x - 1, y - 1] * filter[0][0])
                convolution = convolution + (ascent_image[x - 1, y] * filter[0][1])
                convolution = convolution + (ascent_image[x - 1, y + 1] * filter[0][2])
                convolution = convolution + (ascent_image[x, y - 1] * filter[1][0])
                convolution = convolution + (ascent_image[x, y] * filter[1][1])
                convolution = convolution + (ascent_image[x, y + 1] * filter[1][2])
                convolution = convolution + (ascent_image[x + 1, y - 1] * filter[2][0])
                convolution = convolution + (ascent_image[x + 1, y] * filter[2][1])
                convolution = convolution + (ascent_image[x + 1, y + 1] * filter[2][2])

                # Multiply by weight
                convolution = convolution * weight

                # Check the boundaries of the pixel values
                if (convolution < 0):
                    convolution = 0
                if (convolution > 255):
                    convolution = 255

                # Load into the transformed image
                image_transformed[x, y] = convolution
        plt.gray()
        plt.grid(False)
        plt.imshow(image_transformed)
        plt.show()

    def manual_maxpooling(self, ascent_image):
        image_transformed = np.copy(ascent_image)
        size_x = image_transformed.shape[0]
        size_y = image_transformed.shape[1]

        new_x = int(size_x / 2)
        new_y = int(size_y / 2)

        # Create blank image with reduced dimensions
        newImage = np.zeros((new_x, new_y))

        # Iterate over the image
        for x in range(0, size_x, 2):
            for y in range(0, size_y, 2):
                # Store all the pixel values in the (2,2) pool
                pixels = []
                pixels.append(image_transformed[x, y])
                pixels.append(image_transformed[x + 1, y])
                pixels.append(image_transformed[x, y + 1])
                pixels.append(image_transformed[x + 1, y + 1])

                # Get only the largest value and assign to the reduced image
                newImage[int(x / 2), int(y / 2)] = max(pixels)

        # Plot the image. Note the size of the axes -- it is now half of the image loaded earlier
        plt.gray()
        plt.grid(False)
        plt.imshow(newImage)
        plt.show()

    def show_image_by_plt(
            self,
            next_horse_pix,
            next_human_pix,
            nrows = 4,
            ncols = 4,
    ):
        # Set up matplotlib fig, and size it to fit 4x4 pics
        fig = plt.gcf()
        fig.set_size_inches(ncols * 3, nrows * 3)

        k = nrows * ncols / 2
        assert isinstance(k, int)
        assert len(next_horse_pix) == k
        assert len(next_human_pix) == k

        for i, img_path in enumerate(next_horse_pix + next_human_pix):
            # Set up subplot; subplot indices start at 1
            sp = plt.subplot(nrows, ncols, i + 1)
            sp.axis('Off')  # Don't show axes (or gridlines)

            img = mpimg.imread(img_path)
            plt.imshow(img)

        plt.show()

    @staticmethod
    def show_training(history):
        '''Plots the training and validation loss and accuracy from a history object'''
        acc = history.history['accuracy']
        val_acc = history.history['val_accuracy']
        loss = history.history['loss']
        val_loss = history.history['val_loss']

        epochs = range(len(acc))

        fig, ax = plt.subplots(1, 2, figsize=(12, 6))
        ax[0].plot(epochs, acc, 'bo', label='Training accuracy')
        ax[0].plot(epochs, val_acc, 'b', label='Validation accuracy')
        ax[0].set_title('Training and validation accuracy')
        ax[0].set_xlabel('epochs')
        ax[0].set_ylabel('accuracy')
        ax[0].legend()

        ax[1].plot(epochs, loss, 'bo', label='Training Loss')
        ax[1].plot(epochs, val_loss, 'b', label='Validation Loss')
        ax[1].set_title('Training and validation loss')
        ax[1].set_xlabel('epochs')
        ax[1].set_ylabel('loss')
        ax[1].legend()

        plt.show()

    @staticmethod
    def demo_augmentation(sample_image, model, NUM_AUG):
        '''Takes a single image array, then uses a model to generate num_aug transformations'''

        # Instantiate preview list
        image_preview = []
        # Convert input image to a PIL image instance
        sample_image_pil = tf.keras.utils.array_to_img(sample_image)
        # Append the result to the list
        image_preview.append(sample_image_pil)

        # Apply the image augmentation and append the results to the list
        for i in range(NUM_AUG):
            sample_image_aug = model(tf.expand_dims(sample_image, axis=0))
            sample_image_aug_pil = tf.keras.utils.array_to_img(tf.squeeze(sample_image_aug))
            image_preview.append(sample_image_aug_pil)

        # Instantiate a subplot
        fig, axes = plt.subplots(1, NUM_AUG + 1, figsize=(12, 12))

        # Preview the images.
        for index, ax in enumerate(axes):
            ax.imshow(image_preview[index])
            ax.set_axis_off()

            if index == 0:
                ax.set_title('original')
            else:
                ax.set_title(f'augment {index}')

    @staticmethod
    def model_augmentation(FILL_MODE='nearest', inputshape=(150, 150, 3)):
        # Create the augmentation model.
        return tf.keras.Sequential([
            # Specify the input shape.
            tf.keras.Input(shape=inputshape),
            # Add the augmentation layers
            tf.keras.layers.RandomFlip("horizontal"),
            tf.keras.layers.RandomRotation(0.2, fill_mode=FILL_MODE),
            tf.keras.layers.RandomTranslation(0.2, 0.2, fill_mode=FILL_MODE),
            tf.keras.layers.RandomZoom(0.2, fill_mode=FILL_MODE)
        ])

    @staticmethod
    def model_augmentation_(
            model,
            inputshape=(150, 150, 3),
            optimizer=tf.keras.optimizers.RMSprop(learning_rate=0.0001),
            loss='binary_crossentropy',
            metrics=('accuracy', )
    ):
        # Create the augmentation model.
        data_augmentation = tf.keras.Sequential([
            tf.keras.layers.RandomFlip("horizontal"),
            tf.keras.layers.RandomRotation(0.4),
            tf.keras.layers.RandomTranslation(0.2,0.2),
            tf.keras.layers.RandomContrast(0.4),
            tf.keras.layers.RandomZoom(0.2),
        ])
        inputs = tf.keras.Input(shape=inputshape)
        x = data_augmentation(inputs)
        x = model(x)

        model = tf.keras.Model(inputs, x)
        model.compile(
            optimizer=optimizer,
            loss=loss,
            metrics=metrics
        )
        return model


if __name__ == '__main__':
    SHUFFLE_BUFFER_SIZE = 1000
    PREFETCH_BUFFER_SIZE = tf.data.AUTOTUNE

    rescale_layer = tf.keras.layers.Rescaling(scale=1. / 255)
    callbacks = myCallback()

    p = Preview_10102025()
    p.c1w2()
# C2__week_4 done
