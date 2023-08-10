from basic_pitch.inference import predict_and_save, predict


def get_midi_from_audio(input_path: str, output_path: str, threshold=0.3):
    predict_and_save(
        [input_path],
        output_path,
        True,
        True,
        False,
        False,
        frame_threshold=threshold
    )

def get_data_from_audio(input_path: str):
    model_output, midi_data, note_events = predict(input_path)
    return model_output, midi_data, note_events
