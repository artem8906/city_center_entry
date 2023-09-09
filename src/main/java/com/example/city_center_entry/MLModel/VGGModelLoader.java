package com.example.city_center_entry.MLModel;

import org.tensorflow.*;
import org.tensorflow.types.UInt8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VGGModelLoader {

        private Graph graph;
        private Session session;

        public VGGModelLoader(String modelPath) {
            try {
//                TensorFlow.init();
                graph = new Graph();
                byte[] model = Files.readAllBytes(Paths.get(modelPath));
                graph.importGraphDef(model);
                session = new Session(graph);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public float[] predictImage(String imagePath) throws IOException {
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            try (Tensor<String> image = Tensors.create(Files.readAllBytes(Paths.get(imagePath)))) {
                Tensor<Float> input = session.runner()
                        .feed("input_1", image) // Replace with the appropriate input layer name
                        .fetch("dense_2/Softmax") // Replace with the appropriate output layer name
                        .run()
                        .get(0)
                        .expect(Float.class);

                float[] predictions = new float[(int) input.shape()[1]];
                input.copyTo(predictions);

                return predictions;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public void close() {
            session.close();
            graph.close();
        }
    }


